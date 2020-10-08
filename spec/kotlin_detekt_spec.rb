require File.expand_path("../spec_helper", __FILE__)

module Danger
  describe Danger::DangerKotlinDetekt do
    it "should be a plugin" do
      expect(Danger::DangerKotlinDetekt.new(nil)).to be_a Danger::Plugin
    end

    #
    # You should test your custom attributes and methods here
    #
    describe "with Dangerfile" do
      before do
        @dangerfile = testing_dangerfile
        @kotlin_detekt = @dangerfile.kotlin_detekt

        allow(@kotlin_detekt.git).to receive(:deleted_files).and_return([])
        allow(@kotlin_detekt.git).to receive(:added_files).and_return([])
        allow(@kotlin_detekt.git).to receive(:modified_files).and_return([])
        # # mock the PR data
        # # you can then use this, eg. github.pr_author, later in the spec
        # json = File.read(File.dirname(__FILE__) + "/support/fixtures/github_pr.json") # example json: `curl https://api.github.com/repos/danger/danger-plugin-template/pulls/18 > github_pr.json`
        # allow(@kotlin_detekt.github).to receive(:pr_json).and_return(json)
      end

      it "Fails if gradlew does not exist" do
        allow(@kotlin_detekt).to receive(:`).with("ls gradlew").and_return("")

        @kotlin_detekt.detekt
        expect(@kotlin_detekt.status_report[:errors]).to eq(["Could not find `gradlew` inside current directory"])
      end

      it "Fails if severity is an unknown value" do
        allow(@kotlin_detekt).to receive(:`).with("ls gradlew").and_return("gradlew")
        allow(File).to receive(:exists?).with(@kotlin_detekt.report_file).and_return(true)

        @kotlin_detekt.severity = "Dummy"
        @kotlin_detekt.detekt

        expect(@kotlin_detekt.status_report[:errors]).to eq(["'Dummy' is not a valid value for `severity` parameter."])
      end

      it "Sets severity to 'warning' if no severity param is provided" do
        allow(@kotlin_detekt).to receive(:`).with("ls gradlew").and_return("gradlew")
        allow(File).to receive(:exists?).with(@kotlin_detekt.report_file).and_return(true)

        fake_result = File.open("spec/fixtures/detekt-result-with-everything.xml")
        allow(File).to receive(:open).with(@kotlin_detekt.report_file).and_return(fake_result)

        @kotlin_detekt.detekt
        expect(@kotlin_detekt.severity).to eq("warning")
      end

      # # Some examples for writing tests
      # # You should replace these with your own.
      #
      # it "Warns on a monday" do
      #   monday_date = Date.parse("2016-07-11")
      #   allow(Date).to receive(:today).and_return monday_date
      #
      #   @kotlin_detekt.warn_on_mondays
      #
      #   expect(@dangerfile.status_report[:warnings]).to eq(["Trying to merge code on a Monday"])
      # end
      #
      # it "Does nothing on a tuesday" do
      #   monday_date = Date.parse("2016-07-12")
      #   allow(Date).to receive(:today).and_return monday_date
      #
      #   @kotlin_detekt.warn_on_mondays
      #
      #   expect(@dangerfile.status_report[:warnings]).to eq([])
      # end
    end
  end
end
