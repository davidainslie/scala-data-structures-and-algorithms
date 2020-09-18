(ns chap2
  (:require
    [clojure.test :refer :all]
    [clojure.string :refer [lower-case split]]))

; Cheat:
; user=> (frequencies ['a 'b 'a 'a])
; {a 3, b 1}

(def words '("this" "is" "a" "that" "is" "a"))

(defn word-count
  "Return a hash of unique words and how many times they appeared in the given list of words"
  [words]
  (->> words
       (map lower-case)
       (group-by identity)
       (reduce (fn [acc [word matches]]
                 (assoc acc word (count matches)))
               {})))

(println (word-count words))

(println (word-count (split "this is a that is a" #"\W+")))