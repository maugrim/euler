(ns euler.40
  (:use [euler.utils :only [digits]]))

(defn concatenate-digits [min max]
  (apply concat (map digits (range min max))))

(defn extract-indexes [seq indexes]
  (keep-indexed (fn [idx item] (if (contains? indexes idx) item nil)) seq))
