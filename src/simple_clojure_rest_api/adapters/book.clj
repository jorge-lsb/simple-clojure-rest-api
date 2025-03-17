(ns simple-clojure-rest-api.adapters.book
  (:require [schema.core :as s]
            [simple-clojure-rest-api.schema.book :as schema.book]))

(s/defn response->books :- schema.book/Book
        [{:keys [name]}]
        {:name name})
