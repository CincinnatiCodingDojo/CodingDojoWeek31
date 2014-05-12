(ns cerealize.core-test
  (:require [clojure.test :refer :all]
            [cerealize.core :refer :all]
            [midje.sweet :refer :all]))

(fact "Write nil to json"
	(write-json nil) => "null" 
	)
(fact "Write boolean to json"
	(write-json false) => "false"
	(write-json true) => "true")

(fact "Write String to json"
	(write-json "stuff") => "\"stuff\""
	)

(fact "Write number to json"
	(write-json 1) => "1")

(fact "Write keyword to json"
	(write-json :keyword) => "\"keyword\"")

(fact "Write vector to json"
	(write-json [1 2 3]) => "[1,2,3]" )

(fact "Write map to json"
	(write-json {"key1" "val1" "key2" "val2"} ) => "{\"key1\":\"val1\",\"key2\":\"val2\"}"
	)