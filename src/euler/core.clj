(ns euler.core
  (:gen-class)
  (:require [clojure.string :as str])
  (:require [clojure.set :as set]))

(defn palindrome?
  "Checks if a number is a palindrome"
  [x]
  (= (str x) (str/reverse (str x))))

(defn sieve
  "Sieve of Eratosthenes for sorted set of integers"
  [primes candidates]
  (if (empty? candidates) primes ;;if candidates are exhausted, we're done
                          ;;otherwise:
                          ;;1. pull the first candidate out as prime
                          ;;2. difference out multiples of that prime
                          ;;3. recur using remaining candidates
                          (let [newprime (first candidates) rangeend (+ 1 (apply max candidates))]
                            (if (> (* newprime newprime) rangeend) ;;Save some time - if we're past sqrt(newprime) in the set, all remaining must be prime
                              (set/union primes candidates)
                              (recur (conj primes newprime) (set/difference candidates (range newprime rangeend newprime)))))))

(defn -main
  [& args]
  (println "Euler problem #4:" (apply max (for [x (range 100 1000) y (range 100 1000) :when (palindrome? (* x y))] (* x y))))
  (println "Euler problem #7:" (nth (seq (sieve (sorted-set) (apply sorted-set (range 2 200000)))) 10000)))