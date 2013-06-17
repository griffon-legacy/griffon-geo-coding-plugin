
Geo Coding services
-------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/geo-coding](http://artifacts.griffon-framework.org/plugin/geo-coding)


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

