APP_CLASS_SOURCE = 'app/src/main/java/rawe/gordon/com/buckreconstruct/application/CustomApp.java'

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
    ':oneres'
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
    ':appcompat'
  ]
)

android_build_config(
  name = 'buildconfig',
  package = 'rawe.gordon.com.buckreconstruct'
)

android_library(
  name = 'mainlib',
  srcs = glob(['app/src/**/*.java'], excludes = [APP_CLASS_SOURCE]),
  deps = [
    ':onelib',
    ':appcompat',
    ':buildconfig',
    ':mainres',
    ':alljars'
  ]
)

android_prebuilt_aar(
  name = 'appcompat',
  aar = 'app/libs/appcompat-v7-19.1.0.aar'
)