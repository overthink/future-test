(ns future)

(defn -main [& argv]
  (doseq [i (range 2000000)]
    (send-off (agent nil) (fn [_]
                  (println (format "in send-off %d" i))
                  (Thread/sleep 5000))))
  (shutdown-agents))

