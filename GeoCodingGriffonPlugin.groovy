/*
 * Copyright 2012-2013 the original author or authors.
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

/**
 * @author Andres Almiray
 */
class GeoCodingGriffonPlugin {
    // the plugin version
    String version = '1.0.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.3.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [wslite: '1.1.0']
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, qt
    List toolkits = []
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-geo-coding-plugin'
    // Map of Bnd directives and/or Manifest entries
    // see http://www.aqute.biz/Bnd/Bnd for reference
    /*Map manifest = [
        'Bundle-Description': 'Plugin summary/headline'
    ]*/

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ],
        [
            name: 'Dani Latorre',
            email: 'dani@danilat.com'
        ]
    ]
    String title = 'Geo Coding services'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
Provides a wrapper to [google maps geocoding service][1]. This is a port of the
[localizable][2] plugin for Grails by Dani Latorre (@dani_latorre).

Usage
----
This plugin adds a new service `griffon.plugins.geocoding.GeoCodingService`
exposing the following methods

 * Map<String, String> findLatLngByAddress(String address)
 * List<Map<String, String>> findLatLngsByAddress(String address)
 * String findAddressByLatLng(String lat, String lng)
 * List<String> findAddressesByLatLng(String lat, String lng)
 * JSONArray findPointsByAddress(String address)
 * JSONArray findPointsByLatLng(String lat, String lng)

The last two methods will give you access to the raw data as returned by the
geocoding resolver.

[1]: https://developers.google.com/maps/documentation/javascript/geocoding
[2]: http://grails.org/plugin/localizable
[3]: https://twitter.com/dani_latorre
'''
}
