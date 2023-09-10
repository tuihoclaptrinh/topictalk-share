CREATE TRIGGER handle_expired_tokens
    AFTER INSERT ON user
    FOR EACH ROW
BEGIN
    IF NEW.dob < NOW() THEN
    UPDATE user SET token = NULL WHERE id = NEW.id;
END IF;
END;