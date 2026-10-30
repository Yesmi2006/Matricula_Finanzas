-- Lote Pagos (items 27 y 29 del documento MATRICULAS Y FINANZAS).
-- Items 22-24 (Pago, Estado de pago, Metodo de pago) ya estan cubiertos por la tabla pagos existente.

-- Item 27, Operacion real.
CREATE TABLE vouchers (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    numero_voucher VARCHAR(50) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_vouchers_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);

-- Item 29, Operacion real.
CREATE TABLE recaudaciones_ventanilla (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    id_cajero BIGINT NOT NULL,
    numero_ventanilla VARCHAR(20) NOT NULL,
    monto_recaudado DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_recaudaciones_ventanilla_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);
