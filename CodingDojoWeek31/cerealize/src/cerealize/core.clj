(ns cerealize.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))

(defn write_map_entry [obj]
	(str (write-json (key obj))
	":" (write-json (val obj)))
	)

(defn write-json [obj]
	(cond
		(nil? obj) "null"
		(true? obj) "true" 
		(false? obj) "false"
		(number? obj) (str obj)
		(keyword? obj) (write-json (name obj))
		(vector? obj) (as-> obj _____
 			                (map write-json _____)
 			                (interpose "," _____)
 			                (apply str _____)
                    	    (str "[" _____ "]"))
		(map? obj) (map write_map_entry obj)
		:else (str "\"" obj "\""))
	)



