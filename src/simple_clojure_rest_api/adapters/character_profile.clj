(ns simple-clojure-rest-api.adapters.character-profile
  (:require [simple-clojure-rest-api.logic.logic :as logic]
            [simple-clojure-rest-api.schema.character-profile :as schema.character-profile]
            [schema.core :as s]))

(s/defn response->character :- schema.character-profile/CharacterProfile
        [{:keys [race name spouse
                 hair gender death
                 wikiUrl birth]}]
        {:race     (logic/parse-string->keyword race)
         :name     name
         :spouse   spouse
         :hair     hair
         :gender   gender
         :death    death
         :birth    birth
         :wiki-url wikiUrl})