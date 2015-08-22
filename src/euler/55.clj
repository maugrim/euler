(ns euler.55
  (:use [euler.utils :only [digits palindrome?]]))

(defn reverse-digits [n]
  (if (= n 0)
    n
    (->> (digits n) reverse (drop-while zero?) (apply str) read-string)))

(defn lychrel-step [n]
  (+' n (reverse-digits n)))

(defn lychrel? [max-steps n]
  (not-any? palindrome? (take max-steps (drop 1 (iterate lychrel-step n)))))

(defn lychrel-nums [max-steps start end]
  (filter (partial lychrel? max-steps) (range start end)))

; euler.55> (count (lychrel-nums 50 0 10000))
; 249
