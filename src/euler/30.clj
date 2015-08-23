(ns euler.30
  (:use [euler.utils :only [digits]]))

(defn power-sum [n expt]
  (apply + (map #(int (Math/pow % expt)) (digits n))))

;; euler.30> (def nums (filter #(= % (power-sum % 5)) (range 0 1000000)))
;; #<Var@3e02e5d8: (0 1 4150 4151 54748 92727 93084 194979)>
