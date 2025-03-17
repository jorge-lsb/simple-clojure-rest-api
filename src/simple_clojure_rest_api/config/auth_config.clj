(ns simple-clojure-rest-api.config.auth-config)

(def token-string
  (str "Bearer " (System/getenv "ONE_API_TOKEN")))

(def header-map
  (assoc-in {} [:headers :Authorization] token-string))