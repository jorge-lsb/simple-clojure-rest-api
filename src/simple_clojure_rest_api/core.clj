(ns simple-clojure-rest-api.core
  (:gen-class)
  (:require [simple-clojure-rest-api.diplomat.http-client :as http-client]))

(defn -main
  []
  (println "---------------------------------")
  (println "Select one option below")
  (println "[1] get books")
  (println "[2] get movies")
  (println "[3] get character-elf")
  (println "[4] get character-human")
  (println "[5] get all character races")
  (println "---------------------------------")
  (let [input-string (read-line)]
    (case input-string
      "1" (println (http-client/get-books))
      "2" (println (http-client/get-movies))
      "3" (println (http-client/get-characters :elf))
      "4" (println (http-client/get-characters :human))
      "5" (println (http-client/get-characters nil)))))