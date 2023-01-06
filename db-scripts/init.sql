CREATE DATABASE Java1
GO
USE Java1
GO

-- TABLES --

CREATE TABLE Category
(
	IDCategory INT PRIMARY KEY IDENTITY,
	[Name] NVARCHAR(25) NOT NULL
)
GO

CREATE TABLE Article
(
	IDArticle INT PRIMARY KEY IDENTITY,
	Title NVARCHAR(300),
	Link NVARCHAR(300),
	[Description] NVARCHAR(900),
	PicturePath NVARCHAR(90),
	PublishedDate NVARCHAR(90),
	CategoryID INT FOREIGN KEY REFERENCES [Category](IDCategory)
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
	[Password] NVARCHAR(50) NOT NULL,
	RoleID INT FOREIGN KEY REFERENCES [Role](IDRole) NOT NULL
)
GO

INSERT INTO Category VALUES ('News')
INSERT INTO Category VALUES ('Politics')
INSERT INTO Category VALUES ('Gaming')
INSERT INTO [Role] VALUES ('Administrator')
INSERT INTO [Role] VALUES ('User')
INSERT INTO [User] VALUES ('admin', 'admin', 1)
INSERT INTO [User] VALUES ('user', 'user', 2)
GO

-- TABLES -- />

-- PROCEDURES --

CREATE PROCEDURE createUser
	@Username NVARCHAR(25),
	@Password NVARCHAR(50),
	@RoleID INT,
	@IDUser INT OUTPUT
AS
BEGIN 
	INSERT INTO [User] values(@Username, @Password, @RoleID)
	SET @IDUser = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE updateUser
	@Username NVARCHAR(25),
	@Password NVARCHAR(50),
	@RoleID INT,
	@IDUser INT
AS
BEGIN
	UPDATE [User] SET 
		Username = @Username,
		[Password] = @Password,
		RoleID = @RoleID
	WHERE 
		IDUser = @IDUser
END
GO

CREATE PROCEDURE deleteUserByID
	@IDUser INT
AS
BEGIN
	DELETE FROM [User] 
	WHERE IDUser = @IDUser
END
GO

CREATE PROCEDURE deleteUserByUsername
	@Username NVARCHAR(25)
AS
BEGIN
	DELETE FROM [User] 
	WHERE Username = @Username
END
GO

CREATE PROCEDURE selectUserByID
	@IDUser INT
AS
BEGIN
	SELECT * FROM [User] 
	WHERE IDUser = @IDUser
END
GO

CREATE PROCEDURE selectUserByUsername
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
	@CategoryID INT,
	@IDArticle INT OUTPUT
AS 
BEGIN 
	INSERT INTO Article VALUES(@Title, @Link, @Description, @PicturePath, @PublishedDate, @CategoryID)
	SET @IDArticle = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE updateArticle
	@Title NVARCHAR(300),
	@Link NVARCHAR(300),
	@Description NVARCHAR(900),
	@PicturePath NVARCHAR(90),
	@PublishedDate NVARCHAR(90),
	@CategoryID INT,
	@IDArticle INT
	 
AS 
BEGIN 
	UPDATE Article SET 
		Title = @Title,
		Link = @Link,
		[Description] = @Description,
		PicturePath = @PicturePath,
		PublishedDate = @PublishedDate,
		CategoryID = @CategoryID
	WHERE 
		IDArticle = @IDArticle
END
GO

CREATE PROCEDURE deleteArticle
	@IDArticle INT	 
AS 
BEGIN 
	DELETE FROM Article
	WHERE IDArticle = @IDArticle
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
	SELECT * FROM Article
	WHERE IDArticle = @IDArticle
END
GO

CREATE PROCEDURE selectArticles
AS 
BEGIN 
	SELECT * FROM Article
END
GO

CREATE PROCEDURE createCategory
	@Name NVARCHAR(25),
	@IDCategory INT OUTPUT
AS
BEGIN
	INSERT INTO Category VALUES(@Name)
	SET @IDCategory = SCOPE_IDENTITY()
END
GO

CREATE PROCEDURE updateCategory
	@Name NVARCHAR(25),
	@IDCategory INT
AS 
BEGIN 
	UPDATE Category SET 
		[Name] = @Name		
	WHERE 
		IDCategory = @IDCategory
END
GO

CREATE PROCEDURE deleteCategory
	@IDCategory INT	 
AS 
BEGIN 
	DELETE FROM Category
	WHERE IDCategory = @IDCategory
END
GO

CREATE PROCEDURE deleteAllCategories
AS
BEGIN
	DELETE FROM Category
	DBCC CHECKIDENT ('Category', RESEED, 0)
END
GO

CREATE PROCEDURE selectCategoryByID
	@IDCategory INT
AS
BEGIN
	SELECT * FROM Category
	WHERE IDCategory = @IDCategory
END
GO

CREATE PROCEDURE selectCategoryByName
	@Name NVARCHAR(25)
AS
BEGIN
	SELECT * FROM Category
	WHERE [Name] = @Name
END
GO

CREATE PROCEDURE selectCategories
AS 
BEGIN 
	SELECT * FROM Category
END
GO

-- PROCEDURES -- />