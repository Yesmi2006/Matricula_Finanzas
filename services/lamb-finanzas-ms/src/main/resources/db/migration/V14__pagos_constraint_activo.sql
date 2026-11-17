ALTER TABLE pagos DROP CONSTRAINT IF EXISTS uk_pagos_matricula_id;

CREATE INDEX idx_pagos_matricula_id ON pagos (matricula_id);

CREATE UNIQUE INDEX uk_pagos_matricula_id_activo ON pagos (matricula_id)
    WHERE estado IN ('EN_PROCESO', 'APROBADO');
