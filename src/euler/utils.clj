(ns euler.utils)

(defn factorial [n] (if (<= n 1) 1 (* n (factorial (dec n)))))

(defn digits [number]
  (map #(Character/digit % 10) (str number)))

(defn palindrome? [n]
  (let [n-digits (digits n)]
    (= n-digits (reverse n-digits))))
