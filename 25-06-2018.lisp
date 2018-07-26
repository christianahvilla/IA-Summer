(defparameter *ora* '((viernes
                              (llega
                                    (vaquero
                                            (transporte)))
                              (ayer
                                    (mañana
                                            (juego de palabras)))
                      )
                      (hermanos
                              (viven
                                    (mismo
                                          (el tiempo)))
                              (jimmy
                                    (mayo
                                          (hablando del año)))
                        ))
)

(defun describe-location (location nodes a)
    (case a
      (1
        (cadr (cadr (assoc location nodes)))
      )
      (2
        (cadr (cdr (assoc location nodes)))
      )
      (4
        (cdr (cadr (assoc location nodes)))
      )
      (3
        (cadr (cdr (assoc location nodes)))
      )
    )
)


#|
(describe-location 'viernes *ora* 1)

"Un vaquero llega a un pueblo en viernes, se queda 3 dias y va en viernes ¿como lo hizo?"

"un borracho dijo si ayer fuese mañana hoy seria viernes que dia es hoy"

"la madre de Jimmy tiene varios hijos el primero se llama abril el segundo el segundo se llama mayo cual es el nombre del tercero"

"Tres hermanos viven en una casa: son de veras diferentes; si quieres distinguirlos, los tres se parece.
el primero no esta: ha de venir. el segundo no esta: ya se fue.solo esta el tercero, menor de todos; sin el no existirian los otros,
aun asi, el tercero solo existe porque el segundo se converte en el primero si quieres mirarlo no ves mas que otro de sus hermanos.
Dime pues: ¿los tres son uno? ¿o solo dos? ¿o ninguno? si sabes como se llaman reconoceras tres soberanos juntos reinan en un pais que ellos son. en eso son iguales"|#
