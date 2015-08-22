(ns euler.52
  (:use [euler.utils :only [digits]]))

(defn anagram? [m n]
  (= (sort (digits m)) (sort (digits n))))

(defn permuted-multiple? [n min max]
  (every? #(anagram? n (* n %)) (range min (inc max))))

;; euler.52> (first (filter #(permuted-multiple? % 2 6) (drop 1 (range))))
;; 142857
