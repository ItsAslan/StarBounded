<h1>Starbounded: Far Above the Moon</h1>

[Starbounded on Modrinth](https://modrinth.com/mod/starbounded)

[Starbounded on Curseforge](https://www.curseforge.com/minecraft/mc-mods/starbounded)

**Starbounded is for Minecraft Version 1.7.10.** Later, I may port to a newer version such as >1.16, but I wouldn't count on that.

<h1>Download from Github</h1>

Navigate to the **"Releases"** section on the right side of the page. Under the **"Assets"** category at the very bottom, you will find download links for the compiled **JAR**. Once you download this **JAR** you can put it into your mods folder and begin playing. Don't forget to view the **changelog** before swapping versions!

<h1>Building from Source Code</h1>

1. Make sure you have JDK8 installed. If not, download it from [adoptium.net](https://adoptium.net/temurin/releases/?variant=openjdk8&jvmVariant=hotspot)
2. If you don't have git installed, download it from [git](https://git-scm.com/downloads)
3. Open up "Git Bash":
    - Press the Windows Button, type "Git Bash" and press ENTER
4. Enter the directory where you would like the sources to be (advanced users can use any directory)
```bash
 cd $HOME/Downloads
```
5. Download the source code
```bash
git clone https://github.com/ItsAslan/Starbounded.git
```
6. Enter the source code directory
```bash
cd Starbounded
```
6. Build the mod
```bash
./gradlew build
```
6. Locate the mod file.

    + Open up your file explorer.
    + Navigate to where you downloaded the sources.
        + If you exactly followed step 1, it should be `C:/Users/%USER%/Downloads`.
    + Enter the downloaded source tree.
    + Navigate to `build/libs`.
    + Grab the "Starbounded-.jar" one.
        + This is your mod file. With this file, you put it in your Minecraft mods folder.

<h1>Contributing</h1>

1. Follow steps 1-2 from _Building from source_ section
2. Create a directory where the repository will reside
3. Download the forge `src` from [minecraftforge.net](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.7.10.html) and extract it into the directory
4. Download the source code:

- Using Git Bash, enter wherever your directory is located:
```bash
cd $HOME/Downloads
```
- Download the source code:
```bash
git clone https://github.com/ItsAslan/Starbounded.git
```

5. Enter the source directory
```bash
cd Starbounded
```
6. Setup forge decompilation workspace
```bash
./gradlew setupDecompWorkspace
```
<h3>Necessary for Eclipse users</h3>

7. Generate eclipse files
```bash
./gradlew eclipse
```

<h1>Liscense</h1>

This software is licensed under the GNU General Public License v3.0 (GPLv3). The GNU General Public License v3.0 (GPLv3) is a license for free software that allows users to run, study, share, and change the software. Released in 2007 by the Free Software Foundation, it fixes problems from earlier versions, making it easier to work with other licenses and protecting against patent issues. It also stops hardware makers from blocking modified versions of the software. By using GPLv3, developers keep their software free and open, helping people work together and protecting users' rights.

<h1>Mentions</h1>

**Starbounded** is heavily influenced by:
- [Practical Space Fireworks](https://github.com/PracticalSpaceFireworks/PracticalSpaceFireworks)
- [HBMs Nuclear Tech Mod](https://github.com/HbmMods/Hbm-s-Nuclear-Tech-GIT)