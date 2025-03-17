(ns simple-clojure-rest-api.diplomat.http-client
  (:require [cheshire.core :as json]
            [clj-http.client :as client]
            [simple-clojure-rest-api.config.auth-config :as auth-config]
            [simple-clojure-rest-api.schema.book :as schema.book]
            [simple-clojure-rest-api.schema.movie :as schema.movie]
            [simple-clojure-rest-api.adapters.book :as adapters.book]
            [simple-clojure-rest-api.adapters.movie :as adapters.movie]
            [simple-clojure-rest-api.adapters.character-profile :as adapters.character-profile]
            [simple-clojure-rest-api.schema.character-profile :as schema.character-profile]
            [schema.core :as s]))

(def bookmark-settings
  {:book-url       "https://the-one-api.dev/v2/book"
   :movie-url      "https://the-one-api.dev/v2/movie"
   :characters-url "https://the-one-api.dev/v2/character?limit=50"})

(s/defn get-characters :- schema.character-profile/CharactersResponse
  [race :- (s/maybe schema.character-profile/Race)]
  (let [response (client/get (:characters-url bookmark-settings) auth-config/header-map)
        body-parsed (json/parse-string (:body response) true)
        characters (->> (:docs body-parsed) (map #(adapters.character-profile/response->character %)))]
    (if race
      {:characters (filter #(= (:race %) race) characters)}
      {:characters characters})))

(s/defn get-movies :- schema.movie/MoviesResponse
  []
  (let [response (client/get (:movie-url bookmark-settings) auth-config/header-map)
        body-parsed (json/parse-string (:body response) true)
        movies (->> (:docs body-parsed) (map #(adapters.movie/response->movies %)))]
    {:movies movies}))

(s/defn get-books :- schema.book/BooksResponse
  []
  (let [response (client/get (:book-url bookmark-settings))
        body-parsed (json/parse-string (:body response) true)
        books (->> (:docs body-parsed) (map #(adapters.book/response->books %)))]
    {:books books}))