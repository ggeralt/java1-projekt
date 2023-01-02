CREATE DATABASE Java1
GO
USE Java1
GO

-- TABLES --

CREATE TABLE Article
(
	IDArticle INT PRIMARY KEY IDENTITY,
	Title NVARCHAR(300),
	Link NVARCHAR(300),
	[Description] NVARCHAR(900),
	PicturePath NVARCHAR(90),
	PublishedDate NVARCHAR(90)
)
GO

CREATE TABLE [Role]
(
	IDRole INT PRIMARY KEY IDENTITY,
	[Role] NVARCHAR(25) NOT NULL
)
GO

CREATE TABLE [User]
(
	IDUser INT PRIMARY KEY IDENTITY,
	Username NVARCHAR(25) NOT NULL,
	[Password] NVARCHAR(600) NOT NULL,
	RoleID INT FOREIGN KEY REFERENCES [Role](IDRole) NOT NULL
)
GO

INSERT INTO [Role] VALUES ('Administrator')
INSERT INTO [Role] VALUES ('User')
INSERT INTO [User] VALUES ('admin', 'admin', 1)
INSERT INTO [User] VALUES ('user', 'user', 2)
GO

-- TABLES -- />

-- PROCEDURES --

CREATE PROCEDURE createUser
	@Username NVARCHAR(25),
	@Password NVARCHAR(600),
	@RoleID INT,
	@IDUser INT OUTPUT
AS
BEGIN 
	INSERT INTO [User] values(@Username, @Password, @RoleID)
	SET @IDUser = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE selectUser
	@Username NVARCHAR(25)
AS
BEGIN
	SELECT * FROM [User] 
	WHERE Username = @Username
END
GO

CREATE PROCEDURE selectUsers
AS 
BEGIN 
	SELECT * FROM [User]
END
GO

CREATE PROCEDURE deleteUser
	@Username NVARCHAR(25)
AS
BEGIN
	DELETE FROM [User] 
	WHERE Username = @Username
END
GO

CREATE PROCEDURE checkIfUserExists
	@Username NVARCHAR(25),
	@Exists INT OUTPUT
AS
BEGIN
	DECLARE @count INT
	SELECT @count = COUNT(*) FROM [User] WHERE Username = @Username
	IF @count = 1
		BEGIN
			SET @Exists = 1
		END
	ELSE
		BEGIN
			SET @Exists = 0
		END
END
GO

CREATE PROCEDURE createArticle
	@Title NVARCHAR(300),
	@Link NVARCHAR(300),
	@Description NVARCHAR(900),
	@PicturePath NVARCHAR(90),
	@PublishedDate NVARCHAR(90),
	@IDArticle INT OUTPUT
AS 
BEGIN 
	INSERT INTO Article VALUES(@Title, @Link, @Description, @PicturePath, @PublishedDate)
	SET @IDArticle = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE updateArticle
	@Title NVARCHAR(300),
	@Link NVARCHAR(300),
	@Description NVARCHAR(900),
	@PicturePath NVARCHAR(90),
	@PublishedDate NVARCHAR(90),
	@IDArticle INT
	 
AS 
BEGIN 
	UPDATE Article SET 
		Title = @Title,
		Link = @Link,
		[Description] = @Description,
		PicturePath = @PicturePath,
		PublishedDate = @PublishedDate		
	WHERE 
		IDArticle = @IDArticle
END
GO

CREATE PROCEDURE deleteArticle
	@IDArticle INT	 
AS 
BEGIN 
	DELETE  
	FROM 
			Article
	WHERE 
		IDArticle = @IDArticle
END
GO

CREATE PROCEDURE deleteAllArticles
AS
BEGIN
	DELETE FROM Article
	DBCC CHECKIDENT ('Article', RESEED, 0)
END
GO

CREATE PROCEDURE selectArticle
	@IDArticle INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		Article
	WHERE 
		IDArticle = @IDArticle
END
GO

CREATE PROCEDURE selectArticles
AS 
BEGIN 
	SELECT * FROM Article
END
GO

-- PROCEDURES -- />