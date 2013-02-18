/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.plugins.geocoding

import griffon.exceptions.GriffonException
import wslite.json.JSONArray
import wslite.json.JSONObject
import wslite.rest.ContentType
import wslite.rest.RESTClient

/**
 * @author Dani Latorre
 * @author Andres Almiray
 */
class GeoCodingService {
    RESTClient http = new RESTClient(url: 'http://maps.googleapis.com/')

    Map<String, String> findLatLngByAddress(String address) {
        List latLngs = findLatLngsByAddress(address)
        return latLngs.size() > 0 ? latLngs[0] : null
    }

    List<Map<String, String>> findLatLngsByAddress(String address) {
        List points = findPointsByAddress(address)
        def latLngs = []
        points.each { point ->
            point.geometry.location.latitude
            latLngs << [lat: point.geometry.location.lat,
                lng: point.geometry.location.lng]
        }
        return latLngs
    }

    JSONArray findPointsByAddress(String address) {
        return findPoints([sensor: 'false', address: address])
    }

    String findAddressByLatLng(String lat, String lng) {
        List address = findAddressesByLatLng(lat, lng)
        return address.size() > 0 ? address[0] : null
    }

    List<String> findAddressesByLatLng(String lat, String lng) {
        def points = findPointsByLatLng(lat, lng)
        def addresses = []
        points.each { point ->
            addresses << point.formatted_address
        }
        return addresses
    }

    JSONArray findPointsByLatLng(String lat, String lng) {
        return findPoints([sensor: 'false', latlng: "${lat},${lng}"])
    }

    private JSONArray findPoints(Map query) {
        def response = http.get(path: '/maps/api/geocode/json', query: query, accept: ContentType.JSON)
        if (response.statusMessage != 'OK') {
            throw new GriffonException("Unexpected failure: ${response.statusMessage}")
        }
        if (response.json.status != 'OK' && response.json.status != 'ZERO_RESULTS') {
            throw new GriffonException("Googlemaps API error: ${response.json.status}")
        }
        return response.json.results
    }
}