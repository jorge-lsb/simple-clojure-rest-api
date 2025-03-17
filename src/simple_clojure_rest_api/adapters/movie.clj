(ns simple-clojure-rest-api.adapters.movie
  (:require [simple-clojure-rest-api.schema.movie :as schema.movie]
            [schema.core :as s]))

(s/defn response->movies :- schema.movie/Movie
        [{:keys [name runtimeInMinutes budgetInMillions
                 boxOfficeRevenueInMillions academyAwardNominations
                 academyAwardWins rottenTomatoesScore]}]
        {:name                           name
         :academy-award-wins             academyAwardWins
         :runtime-in-minutes             runtimeInMinutes
         :budget-in-millions             budgetInMillions
         :rotten-tomatoes-score          rottenTomatoesScore
         :academy-award-nominations      academyAwardNominations
         :box-office-revenue-in-millions boxOfficeRevenueInMillions})