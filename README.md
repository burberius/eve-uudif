eve-uudif
=========

 Java library for the Eve Online Unified Uploader and Data Interchange Format

Implementation after the specifications at the following page: http://dev.eve-central.com/unifieduploader/start

Usage
----------
For examples how to uses this library, please see the code in the two tests:

- *ParsingTest* shows how to parse the JSON data from the wire into the raw container classes using Jackson
- *DataConverterTest* shows how to transform the raw data as it comes over the wire and is parsed from JSON into POJOs with the right types

Developed By
------------
* Jens Oberender

License
-------

    Copyright 2014 Jens Oberender
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    
    http://www.apache.org/licenses/LICENSE-2.0
    
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
