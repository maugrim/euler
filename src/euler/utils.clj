(ns euler.utils)

(defn factorial [n] (if (<= n 1) 1 (* n (factorial (dec n)))))

(defn digits [number]
  (map #(Character/digit % 10) (str number)))
