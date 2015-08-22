(ns euler.34)

(defn factorial [n] (if (<= n 1) 1 (* n (factorial (dec n)))))

(defn digits [number]
  (map #(Character/digit % 10) (str number)))

(defn curious? [n]
  (= n (reduce + (map factorial (digits n)))))

(defn curious-nums [start end]
  (filter curious? (range start end)))

; euler.34> (curious-nums 0 1000000)
; (1 2 145 40585)
