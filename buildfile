require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/custom_pom'

desc 'GWT Online Indicator Library'
define 'gwt-online' do
  project.group = 'org.realityforge.gwt.online'
  compile.options.source = '1.6'
  compile.options.target = '1.6'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  pom.add_apache_v2_license
  pom.add_github_project("realityforge/gwt-appcache")
  pom.add_developer('realityforge', "Peter Donald")
  pom.provided_dependencies.concat [:javax_annotation, :gwt_user, :gwt_dev]

  compile.with :javax_annotation, :gwt_user

  test.using :testng
  test.with :mockito

  package(:jar).include("#{_(:source, :main, :java)}/*")
  package(:sources)
  package(:javadoc)
end
