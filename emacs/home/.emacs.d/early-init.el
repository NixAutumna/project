(setq gc-cons-threshold most-positive-fixnum)
(add-hook 'after-init-hook #'(lambda () (setq gc-cons-threshold 800000)))
(set-charset-priority 'unicode)
(prefer-coding-system 'utf-8)
(setq system-time-locale "C")
