(ns simple-clojure-rest-api.schema.movie
  (:require [schema.core :as s]))

(def Movie
  {:name                           s/Str
   :academy-award-wins             s/Int
   :runtime-in-minutes             s/Int
   :budget-in-millions             s/Int
   :rotten-tomatoes-score          s/Int
   :academy-award-nominations      s/Int
   :box-office-revenue-in-millions s/Int})

(def MoviesResponse
  {:movies [Movie]})