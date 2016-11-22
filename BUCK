APP_CLASS_SOURCE = 'app/src/main/java/rawe/gordon/com/buckreconstruct/application/CustomApp.java'

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
  ]
)

android_library(
  name = 'mainlib',
  srcs = glob(['app/src/**/*.java'], excludes = [APP_CLASS_SOURCE]),
  deps = [
    ':onelib',
    ':appcompat',
    ':mainres'
  ]
)

android_prebuilt_aar(
  name = 'appcompat',
  aar = 'app/libs/appcompat-v7-19.1.0.aar'
)