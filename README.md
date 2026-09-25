<div align="center">

<h1>365Score Morphe Patches</h1>

Morphe patches for the <strong>365Score</strong> sports app<br>
<em>(com.scores365 · v14.9.5+)</em>

</div>

## 🕹️ Usage

### Morphe Manager

Tap the link to add this as a patch source in Morphe Manager:

> **⚠️ Replace `non7043` with your actual GitHub username before sharing this link**

[**➕ Add 365Score Patches to Morphe**](https://morphe.software/add-source?github=non7043/365score-patches)

Then patch 365Score:
1. Tap the 365Score app icon in Morphe
2. Download the original APKM from ApkMirror — do _not_ unsplit or modify it
3. Wait for patching to complete, then install

### Morphe CLI

```sh
java -jar cli.jar patch --patches 365score-patches.mpp input.apkm
```

## ⚙️ Available Patches

| 💊 Patch | 📜 Description |
|----------|----------------|
| Disable ads | Removes banner and interstitial ads |
| Unlock premium | Unlocks premium features without a subscription |
| Disable analytics | Removes analytics and tracking SDK initialization |
| Block update screen | Blocks the "update required" prompt on launch |
| Change version code | Prevents Play Store from overwriting the patched app |

## 🔧 Development

### Prerequisites

- JDK 17+
- A GitHub account with access to the [MorpheApp registry](https://github.com/orgs/MorpheApp/packages)

### Local build setup

Add your GitHub credentials to `~/.gradle/gradle.properties`:

```properties
gpr.user=YOUR_GITHUB_USERNAME
gpr.key=YOUR_GITHUB_TOKEN
```

> The token needs `read:packages` scope to download the Morphe SDK.

### Build

```sh
./gradlew :patches:build
```

The output `.mpp` file is in `patches/build/libs/`.

### Releasing

Push a tag to trigger a GitHub Release:

```sh
git tag v1.0.0
git push origin v1.0.0
```

## 📋 Target App

| Field | Value |
|-------|-------|
| Package | `com.scores365` |
| Tested version | `14.9.5` (versionCode 1495) |
| Source | [ApkMirror](https://www.apkmirror.com/apk/365scores-ltd/365scores-live-scores-news/) |

## 📄 License

[GNU General Public License v3.0](LICENSE)
