(ns chap1
  (:require [clojure.test :refer :all]))

(defn check? [list]
  (let [[x y] list]
    (> y x)))

(println (check? '(21 2)))

(defn gen-pairs [list]
  (let [x list
        y (rest list)]
    (partition 2 (interleave x y))))

(println (gen-pairs '(1 2 3 4)))

(defn strictly-increasing? [list]
  (every? check? (gen-pairs list)))

(println (strictly-increasing? '(1 2 3 4)))