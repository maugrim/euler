(ns euler.31)

(def all-denominations [1 2 5 10 20 50 100 200])

(def partitions
  (memoize (fn [denominations total]
             (cond (zero? total) 1
                   (empty? denominations) 0
                   :else (let [[x & xs] denominations]
                           (->> (range)
                                (map (partial * x))
                                (map (partial - total))
                                (take-while (complement neg?))
                                (map (partial partitions xs))
                                (apply +)))))))

;; euler.31> (partitions all-denominations 200)
;; 73682
