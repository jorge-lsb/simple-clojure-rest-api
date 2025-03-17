(ns simple-clojure-rest-api.schema.book
  (:require [schema.core :as s]))

(def Book
  {:name s/Str})

(def BooksResponse
  {:books [Book]})