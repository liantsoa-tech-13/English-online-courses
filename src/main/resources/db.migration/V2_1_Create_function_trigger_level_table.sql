-- Step 1: Create a function to update the updated_at column
CREATE OR REPLACE FUNCTION update_level_updated_at()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Step 2: Create a trigger to call the function above before any update on level table
CREATE TRIGGER trg_update_level_updated_at
    BEFORE UPDATE ON level
    FOR EACH ROW
EXECUTE FUNCTION update_level_updated_at();
