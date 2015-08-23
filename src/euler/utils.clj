(ns euler.utils)

(defn square [n] (* n n))

(defn factorial [n] (if (<= n 1) 1 (* n (factorial (dec n)))))

(defn digits [number]
  (map #(Character/digit % 10) (str number)))

(defn palindrome? [n]
  (let [n-digits (digits n)]
    (= n-digits (reverse n-digits))))

(defn perfect-square? [n]
  (let [result (Math/sqrt n)] (= (double 0) (double (- result (int result))))))

 ;; via clojure.contrib.lazy-seqs
(def primes
  (concat
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
          (fn primes-from [n [f & r]]
            (if (some #(zero? (rem n %))
                      (take-while #(<= (* % %) n) primes))
              (recur (+ n f) r)
              (lazy-seq (cons n (primes-from (+ n f) r)))))
          wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
                        6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
                        2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

(def composites
  (let [composites-from
        (fn composites-from [n subsequent-primes]
          (let [next-prime (first subsequent-primes)]
            (lazy-cat (range n next-prime) (composites-from (inc next-prime) (next subsequent-primes)))))]
    (composites-from 2 primes)))
