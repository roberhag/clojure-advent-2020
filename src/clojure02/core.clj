(ns clojure02.core)
(require '[clojure.string :as s])

(defn readlines
  "Reads each line and returns a seq"
  [fname]
  (s/split-lines (slurp fname)))

;part 1
(defn valid-line? [str]
  (let [[pre pwd] (s/split str #": ")
        [a letter] (s/split pre #" ") 
        [low high] (map read-string (s/split a #"-"))
        c (count (re-seq (re-pattern letter) pwd))]
    (and (<= low c) (<= c high))))

;part 2
(defn valid-line-p2? [str]
  (let [[pre pwd] (s/split str #": ")
        [a letter] (s/split pre #" ")
        [low high] (map #(nth pwd % '.) (map dec (map read-string (s/split a #"-"))))]
      (and (or (= (first letter) low) (= (first letter) high)) (not (= low high)))))

(def input (readlines "resources/input02.txt"))

(defn -main [& args]
  (println (count (filter valid-line? input)))
  (println (count (filter valid-line-p2? input)))
)