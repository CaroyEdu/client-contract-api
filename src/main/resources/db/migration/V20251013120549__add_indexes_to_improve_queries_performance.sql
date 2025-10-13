CREATE UNIQUE INDEX IF NOT EXISTS idx_client_public_id ON client(public_id);
CREATE INDEX IF NOT EXISTS idx_contract_client_id ON contract(client_id);
CREATE INDEX IF NOT EXISTS idx_contract_deleted_end_date ON contract(deleted, end_date);