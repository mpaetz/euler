(use 'euler.core)
(use 'clojure.test)

(def world (atom {:inputs []
                  :actual-result nil}))

(Given #"^I have entered the number (\d+)$" [input]
       (swap! world update-in [:inputs] conj (bigdec input)))

(When #"^I press check$" []
      (swap! world assoc :actual-result (apply palindrome? (:inputs @world))))

(Then #"^the result should be (true)$" [result]
      (assert (= (boolean result) (:actual-result @world))))
