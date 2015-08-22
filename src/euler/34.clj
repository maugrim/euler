(ns euler.34
  (:use [euler.utils :only [factorial digits]]))

(defn curious? [n]
  (= n (reduce + (map factorial (digits n)))))

(defn curious-nums [start end]
  (filter curious? (range start end)))

; euler.34> (curious-nums 0 1000000)
; (1 2 145 40585)
