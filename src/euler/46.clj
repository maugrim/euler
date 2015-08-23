(ns euler.46
  (:use [euler.utils :only [primes composites perfect-square?]]))

(defn goldbach? [n primes]
  (let [candidates (take-while #(< % n) primes)]
    (first (filter #(perfect-square? (/ 2 (- n %))) candidates))))
