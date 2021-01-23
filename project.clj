(defproject clojure-reitit-greeting-service "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "APACHE LICENSE, VERSION 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [http-kit "2.3.0"]
                 [ring/ring-core "1.8.2"]
                 [ring/ring-json "0.5.0"]
                 [metosin/reitit "0.5.11"]]
  :main ^:skip-aot clojure-reitit-greeting-service.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
