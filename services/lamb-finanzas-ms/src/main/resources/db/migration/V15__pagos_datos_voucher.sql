ALTER TABLE pagos ADD COLUMN numero_operacion VARCHAR(50);
ALTER TABLE pagos ADD COLUMN banco_referencia VARCHAR(100);
ALTER TABLE pagos ADD COLUMN fecha_voucher TIMESTAMP;
ALTER TABLE pagos ADD COLUMN archivo_voucher VARCHAR(255);

CREATE UNIQUE INDEX uk_pagos_voucher_activo ON pagos (banco_referencia, numero_operacion)
    WHERE banco_referencia IS NOT NULL AND numero_operacion IS NOT NULL AND estado <> 'RECHAZADO';
