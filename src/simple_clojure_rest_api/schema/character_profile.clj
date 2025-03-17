(ns simple-clojure-rest-api.schema.character-profile
  (:require [schema.core :as s]))

(def Race (apply s/enum #{:elf :human}))

(def CharacterProfile
  {:race     Race
   :name     s/Str
   :spouse   s/Str
   :hair     s/Str
   :gender   s/Str
   :death    s/Str
   :birth    s/Str
   :wiki-url s/Str})

(def CharactersResponse
  {:characters [CharacterProfile]})