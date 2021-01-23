(ns clojure-reitit-greeting-service.core
  (:require [org.httpkit.server :refer [run-server]]
            [ring.util.response :refer [response]]
            [ring.middleware.keyword-params :refer [wrap-keyword-params]]
            [reitit.ring :as ring]
            [reitit.ring.middleware.parameters :as parameters])
  (:gen-class))

(def counter (atom 0))

(defn greeting-handler [{{:keys [name] :or {name "World"}} :params}]
  (let [message (format "Hello, %s!" name)]
    (swap! counter inc)
    (response {:id @counter :content message})))

(def router
  (ring/router
    ["/greeting" {:get greeting-handler
                  :name ::greeting}]
    {:data {:middleware [parameters/parameters-middleware
                         wrap-keyword-params]}}))

(def app 
  (ring/ring-handler 
    router
    (ring/create-default-handler)))

(defn start-server []
  (run-server app {:port 8080}))

(defn -main
  "Start server to serve /greeting endpoint"
  [& args]
  (start-server))


(comment
  ;; Stop server
  (server)

  ;; Start server
  (def server (start-server))

  )
