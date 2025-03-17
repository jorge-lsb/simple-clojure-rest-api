(ns simple-clojure-rest-api.logic.logic
  (:require [clojure.string :as str]
            [schema.core :as s]))

(s/defn parse-string->keyword :- s/Keyword
  [string :- s/Str]
  (-> string str/lower-case keyword))