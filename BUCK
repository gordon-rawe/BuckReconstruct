APP_CLASS_SOURCE = 'app/src/main/java/rawe/gordon/com/buckreconstruct/application/DelegateApp.java'

import re

jar_deps = []
for jarfile in glob(['app/libs/*.jar']):
  name = 'jars__' + re.sub(r'^.*/([^/]+)\.jar$', r'\1', jarfile)
  jar_deps.append(':' + name)
  prebuilt_jar(
    name = name,
    binary_jar = jarfile,
  )

android_library(
  name = 'alljars',
  exported_deps = jar_deps,
)

android_library(
  name = 'onelib',
  srcs = glob(['one/src/**/*.java']),
  deps = [
    ':oneres',
    ':onebuildconfig',
    ':supportv4'
  ]
)

android_build_config(
  name = 'onebuildconfig',
  package = 'rawe.gordon.com.one',
  values = [
     'String PARA_ONE = "false"'
  ]
)

android_resource(
  name = 'oneres',
  package = 'rawe.gordon.com.one',
  res = 'one/src/main/res'
)

android_resource(
  name = 'mainres',
  package = 'rawe.gordon.com.buckreconstruct',
  res = 'app/src/main/res',
  deps = [
    ':oneres',
    ':appcompat',
    ':supportv4'
  ]
)

android_build_config(
  name = 'buildconfig',
  package = 'rawe.gordon.com.buckreconstruct',
  values = [
     'String PARA_TWO = "true"'
  ]
)

android_library(
  name = 'mainlib',
  srcs = glob(['app/src/**/*.java'], excludes = [APP_CLASS_SOURCE]),
  deps = [
    ':onelib',
    ':appcompat',
    ':buildconfig',
    ':mainres',
    ':alljars',
    ':supportv4',
    ':animated-drawable',
    ':vector-drawable'
  ]
)

android_prebuilt_aar(
  name = 'appcompat',
  aar = 'app/libs/appcompat-v7-23.3.0.aar'
)

android_prebuilt_aar(
  name = 'supportv4',
  aar = 'app/libs/support-v4-23.3.0.aar'
)

android_prebuilt_aar(
  name = 'vector-drawable',
  aar = 'app/libs/support-vector-drawable-23.3.0.aar'
)

android_prebuilt_aar(
  name = 'animated-drawable',
  aar = 'app/libs/animated-vector-drawable-23.3.0.aar'
)

android_manifest(
  name = 'manifest',
  skeleton = 'app/src/main/AndroidManifest.xml',
  deps = [
    ':mainlib'
  ]
)

android_library(
  name = 'applicationlib',
  srcs = [APP_CLASS_SOURCE],
  deps = [
    ':buildconfig',
    ':jars__buck-android-support'
  ]
)

keystore(
  name = 'keystore',
  store = 'keystore/debug.keystore',
  properties = 'keystore/debug.keystore.properties',
)

android_binary(
  name = 'gordon',
  manifest = ':manifest',
  keystore = ':keystore',
  use_split_dex = True,
  exopackage = True,
  primary_dex_patterns = [
    '^rawe/gordon/com/buckreconstruct/application/DelegateApp^',
    '^rawe/gordon/com/buckreconstruct/BuildConfig^',
    '^com/facebook/buck/android/support/exopackage/'
  ],
  deps = [
    ':mainlib',
    ':applicationlib'
  ]
)