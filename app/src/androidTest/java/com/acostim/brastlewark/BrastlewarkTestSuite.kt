package com.acostim.brastlewark

import com.acostim.brastlewark.data.local.AppDataBaseTest
import com.acostim.brastlewark.data.local.GnomeDaoTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    ExampleInstrumentedTest::class,
    AppDataBaseTest::class,
    GnomeDaoTest::class
)
class BrastlewarkTestSuite