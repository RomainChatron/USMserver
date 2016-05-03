-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 25 Avril 2016 à 09:53
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `usm`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `idA` int(255) NOT NULL,
  `dateA` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idDi` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `chat`
--

CREATE TABLE `chat` (
  `idC` int(255) NOT NULL,
  `nameC` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'Memo'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `data`
--

CREATE TABLE `data` (
  `idDa` int(255) NOT NULL,
  `nameDa` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'fichier',
  `typeDa` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'text',
  `data` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `data`
--

INSERT INTO `data` (`idDa`, `nameDa`, `typeDa`, `data`) VALUES
(1, 'test.txt', '.txt', 0x746f746f0d0a0d0a0d0a0d0a0d0a0d0a0d0a0d0a746f2e0d0a),
(2, 'imgres.jpg', '.jpg', 0xffd8ffe000104a46494600010100000100010000ffdb00840009060713131015121212161515171819181817131718181a19171d17181b1a1919181a1d2920181d251e181d21322126292b2e2e2e191f3338332d37282d2e2d010a0a0a0d0d0d0e0d0d0e2b1915202d2b2d2b2b2b2b2b2b2b2b2b2b2b2d2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2b2bffc000110800a000ac03012200021101031101ffc4001c0001000203010101000000000000000000000506010407020308ffc4003d100002010303020404030701070500000001020300041105122106310713415122326171234281141552628291a1923343a3b1c1d1d32434535572ffc4001501010100000000000000000000000000000001ffc4001511010100000000000000000000000000000001ffda000c03010002110311003f00ee34a52814a52814ac6eaa7f5af8876b600ab1f36603fd9211c1f4f31bb463efcfb034170cd45eafd47696dffb8b98a327b06619ff004f7ae670a6b9ab00c641616cc3b0043329c1c81f3b707dd3b54ee87e105842019b75cbf76690ed563eb9453c8fb93f7a0da6f1634b19fc76383e9149ff003c735f6b6f1474b76c7ed3b3eb223a2fdb7118a99b6e91b08d022595b851e86243fe48cd7c2e7a1b4e77ded650138c708076fa0c0a09f8640ca19482a79041c823d083ea2bdd68dfea105ac3be6748a25c0cb10aa3d001ff006aa36a3e3469919c2196639c7e1a003ee0c8ca08a0e8f4ae636be3869cc70e93c63dd951bf4c46ec7fc55c742eafb2bb205bdc23b119d99c3fd7e13cd04ed2b19acd0294a50294a50294a50294a502bc935eab9af8bfd62d6c82ce027ce987c4ca7948c9da02e39dee72a3db04fb64347af7afe679ff007769996958ec7953921bd563f4181cb39e063fb4b741f86b15a627b9db3dc93bb2c32b1b1efb7392ef9eee7927dab67c32e895b0803c8aa6e5c65881fecd4818894f7c0c649f539fa54f757f50258d9c972c37151844ce37c87e55cfa64f73e8326836757d6aded503dccc91293805ce327d80ee7f4afae97a9457112cb0b878dbe5619c1c7b66b94740f4f3ea939d53513e6a6e2b146dcae54e0f1ffc6a41007a9049f4ae97d410dd9836d8bc314991cccac5428fe10b41334ae53d3fe21ddc7a90d3afd2276f33ca32c395c39c153b4f054823d8f35d54506a6aba5c373198a78d644383b586464720fd0d79d3b4782001608638c0e3e0503ebdc0cfad6f5283e53dbabaed750ca7d18061fd8d50babfc2bb4b8064b6c5adc0395641f06473ca0231ff00e97041e79e41bcdddec710ccb22463b66460a0fd8922beb04a19432b0652320a904107b10477a0e39d35e205d585c9b1d5b25578f38fcc809e1c91c4919fe2ee3d7d71d92290300ca41046411c820f622aa3e25f482dfda9da00b88c1689fd7dcc67f95b1fa1c1f4aa2f825d58524fddd337c2d93016fcac3e78bfe647d88f6a0ed74a52814a52814a52814a5283e3773044676385552c4fb00326b89f86f036a7abcb7f30256322500f60cd910aff004aae7ee2ba2f8ab7623d22e7271bd447c7f3b05c7f626a07c0ab4db6134bc7e24e7fb222281fdc13fad074b35c43c7bd498dd416d9c2244653f56766407fa446dfea35db8d52bc47e835d4511d1824f18215987c2c84e4a3e39c7a83e873c734165e9eb648ad208e3f916340b8f60a315b1a85f47044f2cae11101666638000ae73a1eababd8c296d2e986e827c29245328f84760d9539c7f1719f6af57bd35a8eaaebfbc192d2d51b3fb342de63b919c1673c0c7a1ff19e4056ba0f4d7d4f599351742b0c729939f57002c49cfb2e18fb103debb88aa86add4363a343142e8f1c583b7ca8999473ce5871b89c9ef93c9aa5f5cf8ad6d716661d3e791656650cc1590ac79cb61bd09c6320e46683b266aa1e22f592e9d6e0a85699c911ab1c018f99dbe8073f538155af08baaad56d22b796f37dcc923e124777619760a80b7d003f76aaaddcbfbc7a9d524e6313796aadd847046ce471fc4e8c7ebb87b541210f4fb2da9d67568a5bd95b052db0708aec36b32f3b7d0ed03001e41352ba6f8b491246b3e9935ac27e1431f2800efb4144271ec057560b8ae43e3ceae8560b31f1481fcd60392abb59547be589e07ae2a8ea9a4ea515cc293c2e1e3719561ebe9dbd0d701f1434f6b1d5da587e12e56e23e381267e21c771b973fd78aec9e1be8ef6ba6410cbf3e0bb0fe12ec5f6fe99c5517c7f807fe91fd7322e7f45350753d17515b8b786e13e59634719ef865ce3fcd6f5543c2698b68f6bbbf2a941f656651fe055bea85294a05294a05294a0a4f8c56a64d225dbf91a273f659149a82f016f336d73093ca4c1c03e8ae83b7f52b55fbaa34dfda6ce7b7ce0c91b283df0c47c271f7c570ff0935616daa08dc802706027b7e206f8473cfcc0ae3be587bd4a3f42d63159a5518c53159a50631543f137a32e351680452a4689bf76fdc482d8c3003bf008c71deafb58c504768fa3c56f1471a22831a2a060a0120003bf7f4ae57d55d05796fa8fef0b0459879a2611e76bab9e1979386539273c1009e2bb35608a0e7b73d59aacf108ed74992198f0d25cba08e338c9c0eee3b80703d38f4a746f871e4dc1bdbe945c5d31ddd894463dce4f2ec3b038000e00ae858a014002b91f8ff27c368bebba46ff000a3feb5d72b85789d21bfd6a3b146e14ac04fb338df211c7a2e39f706a0e9be185b6cd22d38396884873eeff001ff6f8aad35f2b78422aa2801540000e0000600c7dabeb54294a50294a50294a5060d702f17fa68daddfed318c453b6e0546364e0e48fd70187d43577ea8dea0d162bcb792de6194718c8eea7d194fa107914115e1ff0053adfd9acbc0957e09541ece077fb302187dfe9567afced6ed75a06a3f182f1918240c24f167394cf0245c9e33c1ce7839aef5a3ead15cc2b342e1d1c6411e9ee0fb11ea2837eb4b57bf1042f298e49368cec894bbb7207c2a39279adc06a93d6be22456130b7fd9e69a765dc8a836ab67b00c793fd2addbb5069bf89fb08f3b4bbf897f88c59c7b700d7a87c5dd38bec90cd1364604b130273db81cd460f15aebff00a4bbff0089ff0082be51f8aeed22abe8d3eec81f999f1ee14c409f53e9dbbd075689c1008ec791f6af75e216ca838233ce0f04647622bdd0294af2c68233a9b5a4b4b496e5f1845c81db7376551f52481fad731f0574779ae26d4e6e496755f506476dd2b7e9f28fbb56975a6ab26b57e9a7d99fc18d89320e5491f0b4c7dd572540cf24feb5d8744d2a3b5b78ede21848d428f73ee49f524e49fbd06f56694a05294a05294a05294a05294a08cea0d0a0bb81a0b84dc87fd4ade8ca7f2b0f7ae3f3e93a86833b4f6f9b8b53cc87b2951dbcd50328c07fbc031dc9e38aee75e590118238edfa7b5056fa4bad6d6fd3f09f6c9f9a1908120fa81f987d47156402a89d4fe17da5c379b013693f70f08c2eee792808e7eaa54fd6a2a29f5fb0f85a38f51880e086db277f7c6738f421bee683a8d6315cd2d7c66b50fe5dddbdc5ac83e65914360fa0c0c39c839f9054edbf899a63f6b903e8cac0ff0091416f02b3544bcf1634c8fb4cefede5c6e73fae302ab9378c32dc49e4e9b60f2391de42188fbc71e4019e325c0a0ead7976912349232a228c96638503ea4d71feaceb3b8d5653a76968c633c492f2bbd338249ff7717f3776f41efed3a1753d4dc49aa5c18a2072225c1238fca83e08cff312c7daba7f4ef4fdbd9c5e55b441178c9fccc47e666eec6823ba13a3a2d3adf62fc52be0cb2631b881c051f9507603feb56715802b340a52940a52940a52940a52940a52940a52940a52941f0b9b549062445719ce1d430cfbe08a8793a2f4f6249b28093dff000d6a7e94103174669eac196ca004720f96bff6a98b7b7545da88aabfc28028fec057da940a52940a52940a52940a52940a52941e734dd50faf5b5af135ca86db8550773649270ab18f9d8e7b609a8bd2912ca1b8beb9516eac03346a4ed8e240422ed0706439c9da3b9039c6485a05c2ee29b86e00315c8c85390091e80e0f3f435f6aa6f4aea9be5731ac66362ef23a3991918608f366c9466c123cb4cec0072738125a3f503dd2a4b6f06606009965731e54b6331aec25f804f3b476009ee02c14a814ea20cc856290c2f208d66ca80c5b2032ae7714c8c6ec7d46473536cd819341eeb19aaf5bf51b33c45a1db04c5fcb90be588542fb9a3db854214e0ee27b640cd7c749d44858e5c167bc9b2abb880b1053b48e38c4481b1eacd8f5e02d19ac544c5ac866b90a85c5be0129c96936ee6455f700af39e4b11e95afd39af3dd16222444538399732ab601db245b3f0db07b163413f4ad6bc9245426340eff00954b6c079f56c1c7bf6a89d2b5f6964995e3454847c534529923ddcee4c98d7e250327190338ee282743738af554fd3f5406f8623666981d8ef20122c2016dcb06dcc70e4282e482599320f1894b4ea249999608e49763bc6eca142ab23153966201391d864f20d04e52a265d7a30ee803b79642c8c8b954638e18fb8c8240ce3352b4006b35561aaa9bb4917cc911d8c51b6551067e731afcd372832d8c01920f7ced6add5b6d6e1cc8ce563e1d910b056c676e4776c7240c9001cd04fd2a0b5aea44803e2392668d3cc9162d9f8698272c5d947383c6727dabe9a95f3192086372ad29f30903910a60b77ed92c89fd4682669414a085d57a6a0b89a39e40fe644aca852578f0ad82c3e023be07f6af43a72008502b0cedcbef62f956dca439248c3006a62b068223f7045860ed23974642cf23121186084f44efdc60d48c56eab188c0c205da00fe1c600fed5ad77a81171140a012e1ddb271b5130091c7277328c7d4d7a3abc02716c668fcf2bbbcadc37edf7db9ce283534be9b82065750ecc836a196479362e00c2ee242f031c579ea9579234b78f3f8f22a48c3236c3f34b861f29280a83eec2a6b3507aa7555b41388659a34f84b3179117672028209c92c49c0fe5341ee0e9bb75df85625d1a325a4772b1b000a46589d8381dbd85786e9887cb48c34a021243095f7fc4bb586fce40238e3158ea7d55a18d4c6d1a97230f2b2aae723080123733fc83db767d3077355d61208d1e4f877ba2052541cb1e725982e14658f3d94e3270283564d00221168c2ddcb89010bbd7784f2f2c991b815efc8e46739efb3a3698d117792432cb26ddf2150a30a30aaa83e551927192724f35b10ea50bc7e724a8d1739903294e0907e2ce3820835f5b4ba4911648d83a30cab290430f70477141a5d43a57ed36ef01964883632f0b0570030380482307183c7209ad21d2d16c286498a98cc4177e115480bc44008c70063e1e2a435ab878e3de8631b48244cdb1597b6ddfd90e48c1208e31eb91b7049940c463201c120e3e991c1fd2821749e998e0f91881df6a2a44bbb18dc5625018fafc59a90d1f4c8eda1486218551ebdc92492c4fa924e49f5ad6d6f5d16e8ede44d27969bdbcb518dbeb86760a4fae335eb4fd4269186eb568908ce5e442c3e8c8b9c7e84d06ad8f4b46800324b222c8d22c6ec02062e5c655546fc31c82d93d8939a9c9a3dc854e7041071df918e2bd035ad67a8248d22ae7f0dcc649ec58005829f5c6707ea08f4a0aee83d2cb66559a5527e08d4c50ac44ae40459181666e79e0aaf3dabe37da25bacc2da152d24ccf249b999c450349be6203121048df06077ddecb56abdb58e68cc7228656182a7d6a2ee2d23b3b77fd9a358d98aa821777c6c42a96c9cb019ed9f4f4a0f9def4c2cbe72bcb27953925e25daa092aabcb01b88c28e33fe38af76dd3e56e12737333158d6321847f10049e484c8c93921700ed1ed538838af5418acd2940ac31acd282b7059dc8bcba97cb40244548e42f921514f96a23dbfc6eec4961e98079a8cb5d2ae81b66fd9e302162ecb2480c924cc855a6690295c8c9f424e7f2e306edb698a0f0c32b8603046083c8fa83ef556d3b4b92dae27f26ce10b2caac92a944544f2a34c1400371b09c0efbbb8ab6e2b18a0a09d2eea4b894c81983b3a9fc254222c802313b4842c65727e04dcd939c11529abe871add25d258473390c1d95630fb8850a599f82a02e3dc7156ac5314145ea0b7bb92e23063511a448c882033a897736f23f11137a8da1778c0c922ad5a0da79502a6d2a72ccc18ab12ccc599895017249278e2a4314c5054b5fb39a59e45fd9fce1b0080c854408c430777ce4ef19c0f84f1db1926a57a5a068ad6385a1f2bca458c2ee56c85503702be9f7a98c5314111d47034912c6a8583cd107c7a46245673f6c2ff9af9754cb388d160573bdf6c8d16d2e91ed624a2b103248099cf1bb38e2a7314c5055b49d2098e62d1cb1a381b22966767ca861b99831d9bb23e1048c01ef8a8be9ed363b5b5060d33cb9e387e292444ded2280bf3265a424966c8c647df157ddb59c5055fa72193cd0e45c11b3f125b8257cd76c11b20c91181cfa02381cf244d5d85792342c4152650a070c146de4e31805d4e3be40addc531405acd2940a52941fffd9);

-- --------------------------------------------------------

--
-- Structure de la table `dataarticle`
--

CREATE TABLE `dataarticle` (
  `idA` int(255) NOT NULL,
  `idDa` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `diary`
--

CREATE TABLE `diary` (
  `idDi` int(255) NOT NULL,
  `nameDi` varchar(32) COLLATE utf8_bin NOT NULL,
  `idG` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `group`
--

CREATE TABLE `group` (
  `idG` int(255) NOT NULL,
  `nameG` varchar(32) NOT NULL,
  `descG` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `group`
--

INSERT INTO `group` (`idG`, `nameG`, `descG`) VALUES
(2, 'ZéroPlusZéro', 'Ca fait la tête a toto.');

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `idM` int(255) NOT NULL,
  `dateM` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idC` int(255) NOT NULL,
  `idDa` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `subtask`
--

CREATE TABLE `subtask` (
  `idST` int(255) NOT NULL,
  `nameST` varchar(32) COLLATE utf8_bin NOT NULL,
  `descST` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `dateST` datetime DEFAULT CURRENT_TIMESTAMP,
  `deadLineST` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `idT` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `task`
--

CREATE TABLE `task` (
  `idT` int(255) NOT NULL,
  `nameT` varchar(32) NOT NULL,
  `descT` varchar(64) DEFAULT NULL,
  `dateT` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deadLineT` date DEFAULT NULL,
  `idG` int(255) NOT NULL,
  `userName` varchar(32) NOT NULL,
  `typeT` enum('1','2','3','4') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `typetask`
--

CREATE TABLE `typetask` (
  `type` enum('1','2','3','4') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '1',
  `descTT` enum('Faible','Normale','Elevée','Urgent') CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT 'Faible'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `userName` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(32) COLLATE utf8_bin NOT NULL,
  `firstName` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(64) COLLATE utf8_bin NOT NULL,
  `job` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'employe'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`userName`, `password`, `firstName`, `lastName`, `email`, `job`) VALUES
('Admin', 'root', 'Admin', 'Admin', 'UltimateSocietyMessenger@gmail.com', 'admin'),
('lermitev', 'cf4b23e2', 'Vivian', 'Lermite', 'lermite.vivian@gmail.com', 'pd'),
('umutonif', '7647d422', 'Fanny', 'Umutoni', 'fanny.umutoni7@gmail.com', 'employe');

-- --------------------------------------------------------

--
-- Structure de la table `userchat`
--

CREATE TABLE `userchat` (
  `userName` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `idC` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `usergroup`
--

CREATE TABLE `usergroup` (
  `idG` int(255) NOT NULL,
  `userName` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Contenu de la table `usergroup`
--

INSERT INTO `usergroup` (`idG`, `userName`, `admin`) VALUES
(2, 'lermitev', 1);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`idA`);

--
-- Index pour la table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`idC`);

--
-- Index pour la table `data`
--
ALTER TABLE `data`
  ADD PRIMARY KEY (`idDa`);

--
-- Index pour la table `dataarticle`
--
ALTER TABLE `dataarticle`
  ADD PRIMARY KEY (`idA`,`idDa`);

--
-- Index pour la table `diary`
--
ALTER TABLE `diary`
  ADD PRIMARY KEY (`idDi`);

--
-- Index pour la table `group`
--
ALTER TABLE `group`
  ADD PRIMARY KEY (`idG`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`idM`);

--
-- Index pour la table `subtask`
--
ALTER TABLE `subtask`
  ADD PRIMARY KEY (`idST`);

--
-- Index pour la table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`idT`);

--
-- Index pour la table `typetask`
--
ALTER TABLE `typetask`
  ADD PRIMARY KEY (`type`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userName`);

--
-- Index pour la table `userchat`
--
ALTER TABLE `userchat`
  ADD PRIMARY KEY (`userName`,`idC`);

--
-- Index pour la table `usergroup`
--
ALTER TABLE `usergroup`
  ADD PRIMARY KEY (`idG`,`userName`),
  ADD KEY `foreign key user` (`userName`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `idA` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `chat`
--
ALTER TABLE `chat`
  MODIFY `idC` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `data`
--
ALTER TABLE `data`
  MODIFY `idDa` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `diary`
--
ALTER TABLE `diary`
  MODIFY `idDi` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `group`
--
ALTER TABLE `group`
  MODIFY `idG` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `idM` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `subtask`
--
ALTER TABLE `subtask`
  MODIFY `idST` int(255) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `task`
--
ALTER TABLE `task`
  MODIFY `idT` int(255) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `usergroup`
--
ALTER TABLE `usergroup`
  ADD CONSTRAINT `foreign key group` FOREIGN KEY (`idG`) REFERENCES `group` (`idG`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `foreign key user` FOREIGN KEY (`userName`) REFERENCES `user` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
