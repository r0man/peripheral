(ns ^{:author "Yannick Scherer"
      :doc "Configurations for Peripheral."}
  peripheral.configuration
  (:require [potemkin :refer [defprotocol+]]))

;; ## Protocol

(defprotocol+ Config
  "Protocol for possibly loadable/reloadable Configurations."
  (load-configuration! [this]
    "Load the configuration data."))

;; ## Basic Implementations

(extend-protocol Config
  clojure.lang.AFunction
  (load-configuration! [f]
    (f))

  clojure.lang.IPersistentMap
  (load-configuration! [m]
    m)

  nil
  (load-configuration! [_]
    nil))